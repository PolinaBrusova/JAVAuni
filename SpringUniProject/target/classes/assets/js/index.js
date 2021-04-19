$(document).ready(function(){
    $("#lrnbtn").click(function (){
        $.ajax({
            url: "http://localhost:8080/trello/AllUsers",
            type: "GET",
            dataType: "json",
            success: function (response){
                console.log(response);
            },
            error: function (response){
                console.log("Что-то пошло не так", response);
            }
        });
    });

    $("#btn2").click(async function (){
        let varData = {
            "login": "n2",
            "firstName": "SLUGNAME",
            "lastName": "LASTNAME",
            "middleName": "HELLO",
            "passwordHash": "1098382309"
        };
        let response = await fetch ("http://localhost:8080/trello/AddUser", {
            method: "POST",
            headers: {
                "Content-Type": "application/json;charset=utf-8"
            },
            body: JSON.stringify(varData)
        });
    });
})