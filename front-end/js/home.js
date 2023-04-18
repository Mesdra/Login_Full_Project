const errordiv = document.getElementById("error-div");


window.onload = function() {
    var token = checkCookie();
    search(token);
};

async function search(token){
    const response = await fetch('http://localhost:8080/usuario/buscar',{
        headers: {
            Authorization: 'Bearer '+ token,
            Accept: 'application/json'
            }
      });
    if(response.status == 200){
        data = await response.json()
        const userdata = document.getElementById("info");
        userdata.value = 'Nome : ' +data.nome + ' | Perfil : '+data.perfil
    }else if(response.status == 403){
        document.location.href = '/login.html';
    }else{
        data = await response.json()
        showErrors(errordiv,data.errors)
    }

}

async function logout(){
    document.location.href = '/login.html';
}

const showErrors = (input, errors) => {

    errors.forEach(element => {
        var smallQuery = document.createElement("small");
        smallQuery.classList.add('row','error','center');
        m = document.createTextNode(element.message);
        smallQuery.appendChild(m)
        input.appendChild(smallQuery)
    })
};


function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }
  
  function checkCookie() {
    let token = getCookie("token");
    if (token == "") {
        document.location.href = '/login.html';
    } else {
     return token;
    }
  }