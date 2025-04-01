import psycopg2
from psycopg2 import sql

def create_database():
    # Connect to PostgreSQL as superuser
    conn = psycopg2.connect(
        dbname="postgres",
        user="test",  # Change to superuser
        password="your_postgres_password",
        host="test"
    )
    conn.autocommit = True
    cursor = conn.cursor()

    # Create database if it doesn't exist
    try:
        cursor.execute("CREATE DATABASE trading")
    except psycopg2.errors.DuplicateDatabase:
        print("Database 'trading' already exists")

    # Grant privileges to test user
    cursor.execute("GRANT ALL PRIVILEGES ON DATABASE trading TO test")
    
    # Close postgres connection
    conn.close()

    # Connect to trading database as superuser
    conn = psycopg2.connect(
        dbname="trading",
        user="test",  # Change to superuser
        password="your_postgres_password",
        host="test"
    )
    cursor = conn.cursor()

    # Grant schema privileges
    cursor.execute("GRANT ALL PRIVILEGES ON SCHEMA public TO test")
    
    # Create the transactions table
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS transactions (
            id SERIAL PRIMARY KEY,
            symbol VARCHAR(10) NOT NULL,
            strike_price DECIMAL NOT NULL,
            premium DECIMAL NOT NULL,
            quantity INTEGER NOT NULL,
            expiration_date DATE NOT NULL
        )
    ''')

    # Grant table privileges
    cursor.execute("GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO test")
    cursor.execute("GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO test")

    conn.commit()
    conn.close()

if __name__ == "__main__":
    create_database()