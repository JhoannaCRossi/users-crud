$(document).ready(function() {
  loadUsers();
  $('#users').DataTable();
});

async function loadUsers() {
  const request = await fetch('users', {
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
    let userHtml = '<tr><td>'+user.id+'</td><td>'
                            +user.name+'</td><td>'
                            +user.lastName+'</td><td>'+user.email+'</td><td>'
                            +user.phone+'</td>' +
                            '<td><a href="#" class="btn btn-danger btclassNamecle btn-sm">' +
                            '<i class="fas fa-trash"></iclassName </a>' +
                            '</td></tr>';
    listHtmlShow += userHtml;
    document.querySelector('#users tbody').outerHTML = listHtmlShow;
  }



}