function idCheck() {
    if (document.frm.id.value === "") {
        alert("아이디를 입력해주세요");
        document.frm.id.focus();
        return;
    }
    var k = document.frm.id.value;
    var opt = "toolbar=no, menubar=no, resizable=no, width=450, height=200";
    window.open("idCheck?id="+k, "id check", opt);
}

function idok(userid) {
    opener.frm.id.value = document.frm.id.value;
    opener.frm.re_id.value = document.frm.id.value;
    self.close();
}