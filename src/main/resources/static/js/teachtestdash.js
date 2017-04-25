/**
 * Created by ZACH on 4/18/2017.
 */

// Get the modal
//#TODO Issue with question modal, need to understand how it works, may need to duplicate the same functions but for the new modal.
//need to figure out how a modal works
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
    $.ajax({
        type: "GET",
        url: "http://localhost:8080//tests/" + inputID,
        dataType: 'json',
        success: function (response) {
            var trHTML = '';
            $.each(response, function (i, item) {
                trHTML += '<tr><td>' + item.var1 + '</td><td>' + item.var2 + '</td><td>' + item.questionText + '</td></tr>';
            });
            $("#modalQuestionTable").append(trHTML);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(textStatus);
            alert(errorThrown);
        }
    });

};

