

let questions = fetch("/responses")
    .then(res => res.json())
    .then(data => data.map(res => res.comments))

// TODO: Display questions in HTML



 /*
 let testResponse = [
    {
        "comments": "one comment",
        "question1": null,
        "question2": null,
        "question3": null,
        "question4": null,
        "question5": null,
        "response1": 1,
        "response2": 2,
        "response3": 3,
        "response4": 4,
        "response5": 5,
        "response_id": 1,
        "time_to_complete": 0,
        "userId": {
            "firstName": null,
            "lastName": null,
            "password": "password123",
            "responses": [],
            "role": "user",
            "team": null,
            "username": "willis123"
        }
    },
    {
        "comments": "oen comment",
        "question1": null,
        "question2": null,
        "question3": null,
        "question4": null,
        "question5": null,
        "response1": 3,
        "response2": 3,
        "response3": 3,
        "response4": 3,
        "response5": 3,
        "response_id": 2,
        "time_to_complete": 0,
        "userId": {
            "firstName": null,
            "lastName": null,
            "password": "password123",
            "responses": [],
            "role": "user",
            "team": null,
            "username": "willis123"
        }
    },
    {
        "comments": "eno comment",
        "question1": null,
        "question2": null,
        "question3": null,
        "question4": null,
        "question5": null,
        "response1": 3,
        "response2": 3,
        "response3": 1,
        "response4": 5,
        "response5": 2,
        "response_id": 3,
        "time_to_complete": 0,
        "userId": {
            "firstName": null,
            "lastName": null,
            "password": "password123",
            "responses": [],
            "role": "user",
            "team": null,
            "username": "willis123"
        }
    },
    {
        "comments": "one comment",
        "question1": null,
        "question2": null,
        "question3": null,
        "question4": null,
        "question5": null,
        "response1": 1,
        "response2": 2,
        "response3": 3,
        "response4": 4,
        "response5": 5,
        "response_id": 4,
        "time_to_complete": 0,
        "userId": {
            "firstName": null,
            "lastName": null,
            "password": "password123",
            "responses": [],
            "role": "user",
            "team": null,
            "username": "willis123"
        }
    },
    {
        "comments": "oen comment",
        "question1": null,
        "question2": null,
        "question3": null,
        "question4": null,
        "question5": null,
        "response1": 3,
        "response2": 3,
        "response3": 3,
        "response4": 3,
        "response5": 3,
        "response_id": 5,
        "time_to_complete": 0,
        "userId": {
            "firstName": null,
            "lastName": null,
            "password": "password123",
            "responses": [],
            "role": "user",
            "team": null,
            "username": "willis123"
        }
    },
    {
        "comments": "eno comment",
        "question1": null,
        "question2": null,
        "question3": null,
        "question4": null,
        "question5": null,
        "response1": 3,
        "response2": 3,
        "response3": 1,
        "response4": 5,
        "response5": 2,
        "response_id": 6,
        "time_to_complete": 0,
        "userId": {
            "firstName": null,
            "lastName": null,
            "password": "password123",
            "responses": [],
            "role": "user",
            "team": null,
            "username": "willis123"
        }
    }
]
  */
 /*
let questions = testResponse.map(res => {
     return res.comments
})
 */