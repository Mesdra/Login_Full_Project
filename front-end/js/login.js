const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const errordiv = document.getElementById("error-div");

loginButton.addEventListener("click", (e) => {
    loginButton.disabled = true;
    removeChilds(errordiv);

    e.preventDefault();
    const username = loginForm.email.value;
    const password = loginForm.pass.value;
    var form = {
        email: username,
        senha : password
    }
    login(form)
            
})

async function login(form){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(form)
    };
    const response = await fetch('http://localhost:8080/auth/login', requestOptions);
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
    
    
    loginButton.disabled = false
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