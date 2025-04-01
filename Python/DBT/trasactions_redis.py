import redis
import json

db = redis.Redis(host='localhost', port=6379, db=0)

def add_transaction(symbol, strike_price, premium, quantity, expiration_date):
    key = f"transaction:{symbol}:{strike_price}:{premium}:{expiration_date}"
    
    if db.exists(key):
        existing_transaction = json.loads(db.get(key))
        existing_transaction['quantity'] += quantity
        db.set(key, json.dumps(existing_transaction))
    else:
        transaction = {
            "symbol": symbol,
            "strike_price": strike_price,
            "premium": premium,
            "quantity": quantity,
            "expiration_date": expiration_date
        }
        db.set(key, json.dumps(transaction))

def remove_transaction(symbol, strike_price, premium, expiration_date):
    key = f"transaction:{symbol}:{strike_price}:{premium}:{expiration_date}"
    db.delete(key)

def get_transactions():
    keys = db.keys("transaction:*")
    transactions = [json.loads(db.get(key)) for key in keys]
    return transactions

def get_transactions_by_symbol(symbol):
    keys = db.keys(f"transaction:{symbol}:*")
    transactions = [json.loads(db.get(key)) for key in keys]
    return transactions

if __name__ == "__main__":
    add_transaction("AAPL", 150.0, 5.5, 1, "2025-03-28")
    add_transaction("AMD", 120.0, 25.0, 1, "2025-03-28")
    print(get_transactions_by_symbol("AAPL"))
    for transaction in get_transactions():
        print(transaction)
