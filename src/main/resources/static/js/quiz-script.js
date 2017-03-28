var currentQuestion = 0;
var correct = 0;
var totalQuestions = questions.length;

var container = document.getElementById('quizContainer');
var question = document.getElementById('question');
var opt1 = document.getElementById('A');
var opt2 = document.getElementById('B');
var opt3 = document.getElementById('C');
var opt4 = document.getElementById('D');
var nextButton = document.getElementById('nextButton');
var result = document.getElementById('result');

function loadQuestion (questionIndex) {
	var q = questions[questionIndex];
	question.innerHTML = (questionIndex + 1) + '. ' + q.question;
	opt1.innerHTML = q.A;
	opt2.innerHTML = q.B;
	opt3.innerHTML = q.C;
	opt4.innerHTML = q.D;
};

function checkAnswer() {
	var selectedOption = document.querySelector('input[type=radio]:checked');
	if(!selectedOption){
		alert('Please select your answer!');
		return;
	}
	var answer = selectedOption.value;
	if(questions[currentQuestion].answer == answer){
		answer.innerHTML = 'Correct';
		correct ++ ;
	}
	selectedOption.checked = false;
	currentQuestion++;
	if(currentQuestion == totalQuestions - 1){
		nextButton.innerHTML = 'Finish';
	}
	if(currentQuestion == totalQuestions){
		container.style.display = 'none';
		result.style.display = '';
		result.innerHTML = 'You get ' + correct + " out of " + totalQuestions + " correct";
		return;
	}
	loadQuestion(currentQuestion);
}



loadQuestion(currentQuestion);

window.addEventListener("load", loadQuestion, false);
