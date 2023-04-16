$(document).ready(function() {
//on ready
});

async function login() {
    let bodyRequest = {};
    bodyRequest.email= document.getElementById('txtEmailLogin').value;
    bodyRequest.password= document.getElementById('txtPasswordLogin').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bodyRequest)
    });

    const response = await request.text();
    if(response == 'ok'){
        window.location.href= 'users.html';
    }else{
        alert("Incorrect Credentials");
    }
}
