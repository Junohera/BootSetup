function go_next() {
    if(document.formm.okon[0].checked === true) {
        document.formm.action = "joinForm";
        document.formm.submit();
    } else if (document.formm.okon[1].checked === true) {
        alert("약관에 동의하셔야합니다.");
    }
};

function loginCheck() {
    if (document.loginFrm.id.value === "") {
        alert("id");
        document.loginFrm.id.focus();
        return false;
    }
    if (document.loginFrm.pwd.value === "") {
        alert("pwd");
        document.loginFrm.pwd.focus();
        return false;
    }
    return true;
};

function idCheck() {
    if (document.formm.id.value === "") {
        alert("id");
        document.formm.id.focus();
        return;
    }
    var id = document.formm.id.value;
    var opt = "toolbar=no, menubar=no, resizable=no, width=450, height=200";
    window.open("idCheckForm?id=" + id, "dupcheck", opt);
};

function post_zip() {
    var url = "findZipNum";
    var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=550, height=300, top=300, left=300";
    window.open(url, "find Zip Num", opt);
};

function go_save() {
    if (document.formm.id.value === "") {
        alert("id");
        document.formm.id.focus();
    } else if (document.formm.reid.value === "") {
        alert("id 중복확인을 해주세요");
        document.formm.reid.focus();
    } else if (document.formm.pwd.value === "") {
        alert("pwd");
        document.formm.pwd.focus();
    } else if (document.formm.pwd.value !== document.formm.pwdCheck.value) {
        alert("pwdCheck");
        document.formm.pwd.focus();
    } else if (document.formm.name.value === "") {
        alert("name");
        document.formm.name.focus();
    } else if (document.formm.email.value === "") {
        alert("id 중복확인을 해주세요");
        document.formm.email.focus();
    } else {
        document.formm.submit();
    }
};

function go_update() {
    if (document.formm.pwd.value !== document.formm.pwdCheck.value) {
        alert("pwd");
        document.formm.pwd.focus();
    }
    else if (document.formm.pwdCheck.value === "") {
        alert("pwdCheck");
        document.formm.pwdCheck.focus();
    }
    else if (document.formm.name.value === "") {
        alert("name");
        document.formm.name.focus();
    }
    else if (document.formm.email.value === "") {
        alert("email");
        document.formm.email.focus();
    } else {
        document.formm.submit();
    }
}

function findIdPw() {
    var url = "findIdPw";
    var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=700, height=500, top=300, left=300";
    window.open(url, "find Id/Pw", opt);
}

function moveId() {
    document.frm.action = "findIdForm";
    document.frm.submit();
};

function movePw() {
    document.frm.action = "findPwForm";
    document.frm.submit();
};