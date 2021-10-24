test

POSTMAN

CREATE

POST , http://localhost:8080/accounts , JSON

{
    "name": "account",
    "balance": 1000.0,
    "date": "2021-11-11",
    "transactions": [{"name":"transact","date":"2021-11-11","amount":20000.0,"description":"premium"},
    {"name":"transact2","date":"2021-11-11","amount":50000.0,"description":"premium_new"}
    ]
}

Status: 201 Created

{
    "id": 1,
    "name": "account",
    "balance": 1000.0,
    "date": "2021-11-11",
    "transactions": [
        {
            "id": 1,
            "name": "transact2",
            "date": "2021-11-11",
            "amount": 50000.0,
            "description": "premium_new"
        },
        {
            "id": 2,
            "name": "transact",
            "date": "2021-11-11",
            "amount": 20000.0,
            "description": "premium"
        }
    ]
}

GET , http://localhost:8080/accounts/1

Status: 200 Ok

{
    "id": 1,
    "name": "account",
    "balance": 1000.0,
    "date": "2021-11-11",
    "transactions": [
        {
            "id": 1,
            "name": "transact2",
            "date": "2021-11-11",
            "amount": 50000.0,
            "description": "premium_new"
        },
        {
            "id": 2,
            "name": "transact",
            "date": "2021-11-11",
            "amount": 20000.0,
            "description": "premium"
        }
    ]
}

DELETE ,   http://localhost:8080/accounts/1

Status: 204 No Content