$(document).ready(function() {
  loadUsers();
  $('#users').DataTable();
});

async function loadUsers() {
  const request = await fetch('api/users', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
    //body: JSON.stringify({a: 1, b: 'Textual content'})
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
                            +user.phone == null ? '-' : user.phone+'</td>' +
                            '<td>'+ buttonDelete +
                            '</td></tr>';
    listHtmlShow += userHtml;
    document.querySelector('#users tbody').outerHTML = listHtmlShow;
  }
}

async function deleteUser(id){
  if(!confirm('¿Desea eliminar este usuario?')){
    return;
  }
  const request = await fetch('api/users/'+id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  document.location.reload();
}