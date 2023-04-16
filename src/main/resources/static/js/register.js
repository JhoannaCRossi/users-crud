$(document).ready(function() {
//on ready
});

async function regirterUsers() {
    let bodyRequest = {};
    bodyRequest.name = document.getElementById('txtName').value;
    bodyRequest.lastName= document.getElementById('txtLastName').value;
    bodyRequest.email= document.getElementById('txtEmail').value;
    bodyRequest.phone= document.getElementById('txtPhone').value;
    bodyRequest.password= document.getElementById('txtPassword').value;

    let repeatPassword = document.getElementById('txtRepeatPassword').value;
    if(repeatPassword != bodyRequest.password){
        alert('Is Different Password!!!')
    }else{
        const request = await fetch('api/users', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(bodyRequest)
        });
        alert('La cuenta fue creada con exito!!');
        window.location.href= 'index.html'
    }
}
