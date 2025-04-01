import sqlite3

def add_transaction(symbol, strike_price, premium, quantity, expiration_date):
    conn = sqlite3.connect("trading.db")
    cursor = conn.cursor()
    
    cursor.execute('''
        SELECT id, quantity FROM transactions WHERE symbol = ? AND strike_price = ? AND premium = ? AND expiration_date = ?
    ''', (symbol, strike_price, premium, expiration_date))
    
    existing_transaction = cursor.fetchone()
    
    if existing_transaction:
        transaction_id, existing_quantity = existing_transaction
        new_quantity = existing_quantity + quantity
        cursor.execute('''
            UPDATE transactions SET quantity = ? WHERE id = ?
        ''', (new_quantity, transaction_id))
    else:
        cursor.execute('''
            INSERT INTO transactions (symbol, strike_price, premium, quantity, expiration_date)
            VALUES (?, ?, ?, ?, ?)
        ''', (symbol, strike_price, premium, quantity, expiration_date))
    
    conn.commit()
    conn.close()

def remove_transaction(symbol, strike_price, premium, expiration_date):
    conn = sqlite3.connect("trading.db")
    cursor = conn.cursor()
    
    cursor.execute('''
        DELETE FROM transactions WHERE symbol = ? AND strike_price = ? AND premium = ? AND expiration_date = ?
    ''', (symbol, strike_price, premium, expiration_date))
    
    conn.commit()
    conn.close()

def get_transactions():
    conn = sqlite3.connect("trading.db")
    cursor = conn.cursor()
    
    cursor.execute("SELECT * FROM transactions")
    transactions = cursor.fetchall()
    
    conn.close()
    return transactions

def get_transactions_by_symbol(symbol):
    conn = sqlite3.connect("trading.db")
    cursor = conn.cursor()
    
    cursor.execute("SELECT * FROM transactions WHERE symbol = ?", (symbol,))
    transactions = cursor.fetchall()
    
    conn.close()
    return transactions


if __name__ == "__main__":
    add_transaction("AAPL", 150.0, 5.5, 1, "2025-03-28")
    add_transaction("AMD", 120.0, 25.0, 1, "2025-03-28")
    print(get_transactions_by_symbol("AAPL"))
    for transaction in get_transactions():
        print(transaction)
