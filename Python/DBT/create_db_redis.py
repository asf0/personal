import redis
import json

def create_database():
    conn = redis.Redis(host='localhost', port=6379, db=0)
    conn.ping()  # Ensure Redis is running
    print("Connected to Redis")
    
if __name__ == "__main__":
    create_database()
