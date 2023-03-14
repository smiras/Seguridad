let usuario
let nombre=$('#nombre').val()
let username=$('#username').val()
let password=$('#password').val()
let rol=$('#rol').val()

usuario.push(nombre, username, password, rol)

$('#guardar').click(function(){
$.ajax({
  type: "POST",
  url: "/user/save",
  data: JSON.stringify(usuario),
  dataType: 'json',
   success : function(json) {
                console.log(usuario);
              },
});
})

$(document).ready(function(){

console.log("Hola");
});