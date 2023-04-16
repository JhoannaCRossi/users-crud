$(document).ready(function() {
  loadUsers();
  $('#users').DataTable();
  showEmailUser();

});

function showEmailUser(){
  document.getElementById('email-user').outerHTML = localStorage.email;
}

function getHeaders(){
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  }
}
async function loadUsers() {
  const request = await fetch('api/users', {
    method: 'GET',
    headers: getHeaders()
  });

  const users = await request.json();

  let listHtmlShow = '';
  for (const user of users) {
    let buttonDelete = '<a href="#" ' +
        ' onclick="deleteUser('+user.id+')" ' +
        'class="btn btn-danger btclassNamecle btn-sm">' +
        '<i class="fas fa-trash"></iclassName </a>';
    let userHtml = '<tr><td>'+user.id+'</td><td>'
                            +user.name+'</td><td>'
                            +user.lastName+'</td><td>'
                            +user.email+'</td><td>'
                            +user.phone+'</td>' +
                            '<td>'+ buttonDelete +
                            '</td></tr>';
    listHtmlShow += userHtml;
    document.querySelector('#users tbody').outerHTML = listHtmlShow;
  }
}

async function deleteUser(id){
  if(!confirm('Do you want to delete this user?')){
    return;
  }
  const request = await fetch('api/users/'+id, {
    method: 'DELETE',
    headers: getHeaders()
  });
  document.location.reload();
}