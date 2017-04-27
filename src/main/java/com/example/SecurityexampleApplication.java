package com.example;
import com.example.Repository.CorrectAnswerRepository;
import com.example.domain.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SecurityexampleApplication implements CommandLineRunner{

    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;
    @Autowired
    private TestAttemptService testAttemptService;
    @Autowired
    private AnswerAttemptService answerAttemptService;

    @Autowired
    private CorrectAnswerRepository correctAnswerRepository;


    @Autowired
    private CorrectAnswerService correctAnswerService;

    public static void main(String[] args) {
        SpringApplication.run(SecurityexampleApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUsername("zach");
        user.setPassword("password");
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setName("ADMIN");
        userRoles.add(new UserRole(user, role));
        userService.createUser(user, userRoles);

        Category category = categoryService.createCategory("Addition");//creates new category of addition
        Category category2 = categoryService.createCategory("Subtraction");
        String date_s = "2011-01-18 00:00:00.0";
        // *** note that it's "yyyy-MM-dd hh:mm:ss" not "yyyy-mm-dd hh:mm:ss"
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = dt.parse(date_s);
        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");


        Test test1 = testService.createTest("test 1", category);//test creation
        Test test2 = testService.createTest("test 2", category2);
        Test test3 = testService.createTest("test 3", category);
        Test test4 = testService.createTest("test 4", category2);
        int var1 = 0;
        int var2 = 0;

        for (int i = 1; i <= 10; i++) // generate questions
        {
            var1 = (int) Math.ceil(10 - 10 * Math.random());
            var2 = (int) Math.ceil(10 - 10 * Math.random());

            Question testQuestion = questionService.createQuestion(var1, var2, "addition", test1);
            CorrectAnswer correctAnswer = correctAnswerService.createCorrectAnswer(var1 + var2, testQuestion);
        }
        for (int i = 1; i <= 10; i++) // generate questions
        {
            while (var1 <= var2) {
                var1 = (int) Math.ceil(10 - 10 * Math.random());
                var2 = (int) Math.ceil(10 - 10 * Math.random());
            }
            Question testQuestion = questionService.createQuestion(var1, var2, "subtraction", test2);
            CorrectAnswer correctAnswer = correctAnswerService.createCorrectAnswer(var1 - var2, testQuestion);
        }
        for (int i = 1; i <= 10; i++) // generate questions
        {
            var1 = (int) Math.ceil(10 - 10 * Math.random());
            var2 = (int) Math.ceil(10 - 10 * Math.random());

            Question testQuestion = questionService.createQuestion(var1, var2, "addition", test3);
            CorrectAnswer correctAnswer = correctAnswerService.createCorrectAnswer(var1 + var2, testQuestion);
        }
        for (int i = 1; i <= 10; i++) // generate questions
        {
            while (var1 <= var2) {

                var1 = (int) Math.ceil(10 - 10 * Math.random());

                var2 = (int) Math.ceil(10 - 10 * Math.random());
            }

            Question testQuestion = questionService.createQuestion(var1, var2, "subtraction", test4);
            CorrectAnswer correctAnswer = correctAnswerService.createCorrectAnswer(var1 - var2, testQuestion);
        }

//        Question testQuestion2 = questionService.createQuestion(1,2,"add",test4);
//        CorrectAnswer correctAnswer = correctAnswerService.createCorrectAnswer(3, testQuestion2);

//        List<Question> testQuestions = questionService.testQuestions(test.getId());
//        for (Question qu : testQuestions)
//        {
//            System.out.print(qu.toString());
//            System.out.println();
//        }
//            questionService.createQuestion(56,67,
//                "answer attempt question",test);
//        TestAttempt testAttempt  = testAttemptService.createTestAttempt(user,test); //issue with createTestAttempt
//        AnswerAttempt answerAttempt = answerAttemptService.createAnswerAttempt(40,
//                testAttempt,question);
//        for(int i = 0; i <=30; i++)
//        {
//            testAttemptService.createTestAttempt(user,test);
//        }
//        List<TestAttempt> testAttempts = testAttemptService.returnTestAttempts(user,test);
//        for(TestAttempt ta : testAttempts)
//        {
//            System.out.println(ta.toString());
//        }
//        Set<Test> tests = testService.findAll();
//        for(Test te : tests)
//        {
//            System.out.println(te.toString());
//        }


        //correctAnswerRepository.save(correctAnswer);

        //System.out.println(correctAnswerRepository.findByQuestionId(testQuestion.getId()).toString());



    }

}