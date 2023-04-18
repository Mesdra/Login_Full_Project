const registerForm = document.getElementById("register-form");
const registerButton = document.getElementById("register-submit");
const errordiv = document.getElementById("error-div");

registerButton.addEventListener("click", (e) => {
    registerButton.disabled = true;
    removeChilds(errordiv);

    e.preventDefault();
    const username = registerForm.email.value;
    const password = registerForm.pass.value;
    const nome = registerForm.name.value;
    var form = {
        email: username,
        senha : password,
        nome : nome
    }
    register(form)
            
})

async function register(form){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(form)
    };
    const response = await fetch('http://localhost:8080/auth/cadastrar', requestOptions);
    if(response.status == 200){
        data = await response.json()
        setCookie("token",data.token)
        document.location.href = '/home.html';
    }else if(response.status == 403){
        showErrors(errordiv,[{message:'Usuario ou Senha Invalido'}])
    }else{
        data = await response.json()
        showErrors(errordiv,data.errors)
    }
    
    registerButton.disabled = false
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

function setCookie(cname, cvalue) {
    const d = new Date();
    d.setTime(d.getTime() + 60000);
    let expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }

function removeChilds(element){
    while (element.firstChild) {
        element.removeChild(element.firstChild);
      }
}