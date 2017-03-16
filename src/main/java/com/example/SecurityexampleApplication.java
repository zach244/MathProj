package com.example;

import com.example.domain.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecurityexampleApplication implements CommandLineRunner {

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
            userRoles.add(new UserRole(user,role));
            userService.createUser(user,userRoles);

        Category category = categoryService.createCategory("Addition");//creates new category of addition

        String date_s = "2011-01-18 00:00:00.0";
        // *** note that it's "yyyy-MM-dd hh:mm:ss" not "yyyy-mm-dd hh:mm:ss"
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = dt.parse(date_s);
        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");


        Test test = testService.createTest("test 1", date, category);//test creation

        for(int i = 0; i <= 30; i++) // generate questions
        {
            questionService.createQuestion(i,i + 1,"Please add both the variables together",test);//Need to create Test service\
        }
//        List<Question> testQuestions = questionService.testQuestions(test);
//        for (Question qu : testQuestions)
//        {
//            System.out.print(qu.toString());
//            System.out.println();
//        }
        Question question = questionService.createQuestion(56,67,
                "answer attempt question",test);
        TestAttempt testAttempt  = testAttemptService.createTestAttempt(user,test); //issue with createTestAttempt
        AnswerAttempt answerAttempt = answerAttemptService.createAnswerAttempt(40,
                testAttempt,question);
        for(int i = 0; i <=30; i++)
        {
            testAttemptService.createTestAttempt(user,test);
        }
        List<TestAttempt> testAttempts = testAttemptService.returnTestAttempts(user,test);
        for(TestAttempt ta : testAttempts)
        {
            System.out.println(ta.toString());
        }
    }
}