function go_cart() {
    if (document.formm.quantity.value === "") {
        alert("수량을 입력하세요");
        document.formm.quantity.focus();
    } else {
        document.formm.action = "cartInsert";
        document.formm.submit();
    }
};

function go_buy() {
    document.formm.action = "immediatelyBuy";
    document.formm.submit();
}

function goCartDelete() {
    var count = 0;
    if (document.formm.cseq.length == undefined) {
        if (document.formm.cseq.checked) {
            count++;
        }
    }

    for (var i = 0; i < document.formm.cseq.length; i++) {
        if (document.formm.cseq[i].checked) {
            count++;
        }
    }

    if (count === 0) {
        alert("삭제할 항목을 선택해주세요");
    } else {
        document.formm.action = "cartDelete";
        document.formm.submit();
    }
};