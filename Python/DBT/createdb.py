import sqlite3

def create_database():
    conn = sqlite3.connect("trading.db")
    cursor = conn.cursor()

    # Create the transactions table
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS transactions (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            symbol TEXT NOT NULL,
            strike_price REAL NOT NULL,
            premium REAL NOT NULL,
            quantity INTEGER NOT NULL,
            expiration_date TEXT NOT NULL
        )
    ''')

    conn.commit()
    conn.close()

if __name__ == "__main__":
    create_database()
