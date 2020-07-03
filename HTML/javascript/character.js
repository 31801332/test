function display(id) {
    var traget = document.getElementById(id);
    if (traget.style.display == "none") {
        traget.style.display = "";
    } else {
        traget.style.display = "none";
    }
}