/**
 * Created by ZACH on 4/18/2017.
 */

// Get the modal


var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
btn.onclick = function () {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
$("#btnDel").click(function () {
    alert(this.id);
});
function getPropId(inputID) {
    alert(inputID);
    $.get("http://localhost:8080/questions/" + inputID, function (data, status) {
        document.getElementById("mainDisplay").innerHTML = JSON.stringify(data);// doesn't work
    });
};