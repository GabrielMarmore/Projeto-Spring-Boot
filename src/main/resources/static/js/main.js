function validaForm(frm){
    if(frm.nome.value == ""){
        alert("Por favor, indique o seu nome.");
        frm.nome.focus();
        return false;
    }

    if(frm.email.value == ""){
        alert("Por favor, campo e-mail não pode ser vazio");
        frm.email.focus();
        return false;
    }
}