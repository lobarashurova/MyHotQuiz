package uz.mlsoft.myhotquiz.presentation.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uz.mlsoft.myhotquiz.R;
import uz.mlsoft.myhotquiz.data.local.QuestionData;
import uz.mlsoft.myhotquiz.domain.DataRepository;
import uz.mlsoft.myhotquiz.presentation.dialog.FinishDialog;

public class TestActivity extends AppCompatActivity {
    private TextView questionTextView;
    private ArrayList<ViewGroup> variants;
    private View selectedItem;
    private DataRepository dataRepository;
    private TextView subject_text;
    private String name;
    private String subjectName;
    private List<QuestionData> mathQuestionData;
    private List<QuestionData> physicsQuestiondata;
    private List<QuestionData> englishQuestionData;
    private int currentQuestion;
    private TextView CurrentQuestionText;
    private int correctCount;
    private int Image;
    private int wrongCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getApplication().setTheme(R.style.Theme_MyHotQuiz);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getApplication().setTheme(R.style.Theme_MyHotQuiz);
        dataRepository = DataRepository.getInstance();
        if (getIntent().getStringExtra("1") != null) {
            loadMathData();
            subjectName = "Mathematics";
            loadMathViews();
            loadDataToMathView();
        } else if (getIntent().getStringExtra("2") != null) {
            quesPhysics();
            subjectName = "Physics";
            loadPhysicsViews();
            loadDataToPhysicsView();
        } else if (getIntent().getStringExtra("3") != null) {
            englishQuestions();
            subjectName = "English";
            loadEnglishViews();
            loadDataToEnglishView();
        } else {
            loadMathData();
            loadMathViews();
            loadDataToMathView();
            subjectName = "Android";
        }

        findViewById(R.id.btn_finish).setOnClickListener(v -> {
            FinishDialog dialog = new FinishDialog();
            dialog.setFinishListener(() -> {
                startActivity(new Intent(this, MainActivity.class));
                finish();
                dialog.dismiss();
            });
            dialog.show(getSupportFragmentManager(), null);
        });
        subject_text = findViewById(R.id.subject_tv);
        subject_text.setText(dataRepository.getSubject_name());

    }

    private void loadMathData() {
        mathQuestionData = new ArrayList<>();

        ArrayList<QuestionData> mathTotal = new ArrayList<>();
        mathTotal.add(new QuestionData("What is 2 + 2?", "4", "5", "3", "6", "4"));
        mathTotal.add(new QuestionData("Simplify: 8 / 2 * (2 + 2)", "16", "8", "4", "10", "16"));
        mathTotal.add(new QuestionData("What is the square root of 49?", "7", "6", "8", "5", "7"));
        mathTotal.add(new QuestionData("What is 3 squared?", "9", "6", "3", "12", "9"));
        mathTotal.add(new QuestionData("Solve for x: 2x + 5 = 15", "5", "10", "7", "8", "5"));
        mathTotal.add(new QuestionData("What is 10 times 0?", "0", "10", "1", "5", "0"));
        mathTotal.add(new QuestionData("What is 3 divided by 1/3?", "9", "6", "3", "1", "9"));
        mathTotal.add(new QuestionData("Simplify: 2 + 3 * 4", "14", "20", "12", "10", "14"));
        mathTotal.add(new QuestionData("What is 20% of 150?", "30", "15", "25", "50", "30"));
        mathTotal.add(new QuestionData("What is 4 factorial (4!)?", "24", "10", "16", "12", "24"));
        mathTotal.add(new QuestionData("Solve for x: 3x - 7 = 14", "7", "6", "5", "8", "7"));
        mathTotal.add(new QuestionData("What is the cube of 2?", "8", "4", "6", "12", "8"));
        mathTotal.add(new QuestionData("What is 1/2 plus 1/4?", "3/4", "1/8", "1/6", "5/8", "3/4"));
        mathTotal.add(new QuestionData("Simplify: 9 - 2 * 3", "3", "0", "6", "5", "3"));
        mathTotal.add(new QuestionData("What is 5 squared?", "25", "10", "15", "20", "25"));
        mathTotal.add(new QuestionData("What is 15 divided by 5?", "3", "2", "5", "4", "3"));
        mathTotal.add(new QuestionData("What is the product of 7 and 9?", "63", "72", "54", "81", "63"));
        mathTotal.add(new QuestionData("What is 100% of 75?", "75", "100", "25", "150", "75"));
        mathTotal.add(new QuestionData("What is 6 times 8?", "48", "64", "56", "52", "48"));
        mathTotal.add(new QuestionData("What is the square root of 144?", "12", "14", "10", "16", "12"));
        mathTotal.add(new QuestionData("What is 1/3 of 21?", "7", "8", "6", "5", "7"));
        mathTotal.add(new QuestionData("What is 3/4 minus 1/4?", "1/2", "1", "1/4", "3/4", "1/2"));
        mathTotal.add(new QuestionData("Simplify: 4 + 2 * 3", "10", "16", "12", "8", "10"));
        mathTotal.add(new QuestionData("What is 18 divided by 3?", "6", "9", "3", "5", "6"));
        mathTotal.add(new QuestionData("What is 10% of 200?", "20", "10", "30", "25", "20"));
        mathTotal.add(new QuestionData("What is 7 squared?", "49", "14", "21", "36", "49"));
        mathTotal.add(new QuestionData("What is 1/5 as a decimal?", "0.2", "0.1", "0.5", "0.25", "0.2"));
        mathTotal.add(new QuestionData("Solve for x: 5x + 8 = 33", "5", "6", "7", "8", "5"));
        mathTotal.add(new QuestionData("What is 25% of 80?", "20", "25", "30", "40", "20"));
        mathTotal.add(new QuestionData("What is 3 times 4?", "12", "8", "7", "10", "12"));
        mathTotal.add(new QuestionData("What is 2 cubed?", "8", "6", "4", "10", "8"));
        mathTotal.add(new QuestionData("What is 9 divided by 3?", "3", "2", "4", "5", "3"));
        mathTotal.add(new QuestionData("What is the square root of 81?", "9", "8", "10", "7", "9"));
        mathTotal.add(new QuestionData("Simplify: 6 / 2 * 3", "9", "6", "4", "5", "9"));
        mathTotal.add(new QuestionData("What is 30% of 150?", "45", "30", "50", "60", "45"));
        mathTotal.add(new QuestionData("What is 2 + 3?", "5", "4", "6", "7", "5"));
        mathTotal.add(new QuestionData("Solve for x: 4x - 10 = 22", "8", "9", "7", "6", "8"));
        mathTotal.add(new QuestionData("What is 8 times 7?", "56", "64", "48", "60", "56"));
        mathTotal.add(new QuestionData("What is 16 divided by 4?", "4", "5", "3", "6", "4"));
        mathTotal.add(new QuestionData("What is 40% of 120?", "48", "40", "30", "50", "48"));
        mathTotal.add(new QuestionData("What is 5 squared?", "25", "10", "15", "20", "25"));
        mathTotal.add(new QuestionData("What is 12 times 9?", "108", "120", "96", "100", "108"));
        mathTotal.add(new QuestionData("What is the cube root of 27?", "3", "2", "4", "5", "3"));
        mathTotal.add(new QuestionData("Simplify: 7 + 3 * 2", "13", "20", "10", "8", "13"));
        mathTotal.add(new QuestionData("What is 1/8 as a percentage?", "12.5%", "8%", "18%", "10%", "12.5%"));
        mathTotal.add(new QuestionData("What is 11 minus 7?", "4", "5", "3", "6", "4"));
        mathTotal.add(new QuestionData("What is 3 divided by 2?", "1.5", "2", "1", "2.5", "1.5"));
        mathTotal.add(new QuestionData("What is 10% of 90?", "9", "10", "8", "7", "9"));
        mathTotal.add(new QuestionData("What is 9 squared?", "81", "64", "49", "100", "81"));
        mathTotal.add(new QuestionData("What is 27 divided by 9?", "3", "2", "4", "5", "3"));
        Collections.shuffle(mathTotal);
        mathQuestionData = mathTotal.subList(0, 20);
    }

    private void quesPhysics() {

        physicsQuestiondata = new ArrayList<>();
        ArrayList<QuestionData> physicsTotal = new ArrayList<>();
        physicsTotal.add(new QuestionData("What is the SI unit of electric current?", "Ampere", "Volt", "Ohm", "Watt", "Ampere"));
        physicsTotal.add(new QuestionData("Which law states that every action has an equal and opposite reaction?", "Newton's Third Law", "Newton's First Law", "Newton's Second Law", "Law of Conservation of Energy", "Newton's Third Law"));
        physicsTotal.add(new QuestionData("What is the speed of light in a vacuum?", "299,792,458 m/s", "100 m/s", "1,000,000 m/s", "186,282 m/s", "299,792,458 m/s"));
        physicsTotal.add(new QuestionData("What is the unit of energy in the SI system?", "Joule", "Newton", "Watt", "Coulomb", "Joule"));
        physicsTotal.add(new QuestionData("What is the force of gravity acting on an object with mass 10 kg?", "98.1 N", "9.8 N", "10 N", "100 N", "98.1 N"));
        physicsTotal.add(new QuestionData("Which type of electromagnetic radiation has the shortest wavelength?", "Gamma rays", "Visible light", "Microwaves", "Radio waves", "Gamma rays"));
        physicsTotal.add(new QuestionData("What is the equation for calculating kinetic energy?", "KE = 0.5 * m * v^2", "KE = m * g * h", "KE = F * d", "KE = P * t", "KE = 0.5 * m * v^2"));
        physicsTotal.add(new QuestionData("What is the SI unit of force?", "Newton", "Watt", "Joule", "Coulomb", "Newton"));
        physicsTotal.add(new QuestionData("What is the process by which a gas changes into a liquid?", "Condensation", "Evaporation", "Sublimation", "Freezing", "Condensation"));
        physicsTotal.add(new QuestionData("What is the unit of electric charge?", "Coulomb", "Ampere", "Ohm", "Volt", "Coulomb"));
        physicsTotal.add(new QuestionData("What is the property of an object to resist changes in its state of motion?", "Inertia", "Gravity", "Friction", "Acceleration", "Inertia"));
        physicsTotal.add(new QuestionData("Which law of thermodynamics states that energy cannot be created or destroyed, only transferred or converted?", "First Law", "Second Law", "Third Law", "Zeroth Law", "First Law"));
        physicsTotal.add(new QuestionData("What is the force that opposes the relative motion or tendency of such motion of two surfaces in contact?", "Friction", "Tension", "Gravity", "Normal force", "Friction"));
        physicsTotal.add(new QuestionData("What is the equation for calculating electric power?", "P = IV", "P = IR", "P = I^2R", "P = V^2/R", "P = IV"));
        physicsTotal.add(new QuestionData("What is the SI unit of power?", "Watt", "Joule", "Ampere", "Volt", "Watt"));
        physicsTotal.add(new QuestionData("What is the law that states that the total pressure exerted by a gas mixture is the sum of the partial pressures of its individual gases?", "Dalton's Law", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Dalton's Law"));
        physicsTotal.add(new QuestionData("What is the rate of change of velocity?", "Acceleration", "Velocity", "Force", "Momentum", "Acceleration"));
        physicsTotal.add(new QuestionData("What is the principle that states that the total electric charge of an isolated system remains constant?", "Conservation of Charge", "Conservation of Energy", "Conservation of Momentum", "Conservation of Mass", "Conservation of Charge"));
        physicsTotal.add(new QuestionData("What is the process by which a liquid changes into a gas?", "Evaporation", "Condensation", "Freezing", "Sublimation", "Evaporation"));
        physicsTotal.add(new QuestionData("What is the SI unit of resistance?", "Ohm", "Watt", "Volt", "Ampere", "Ohm"));
        physicsTotal.add(new QuestionData("What is the law that states that the current through a conductor between two points is directly proportional to the voltage across the two points?", "Ohm's Law", "Newton's Law", "Faraday's Law", "Coulomb's Law", "Ohm's Law"));
        physicsTotal.add(new QuestionData("What is the process of a solid changing directly into a gas without passing through a liquid state?", "Sublimation", "Evaporation", "Condensation", "Melting", "Sublimation"));
        physicsTotal.add(new QuestionData("What is the measure of the amount of matter in an object?", "Mass", "Weight", "Volume", "Density", "Mass"));
        physicsTotal.add(new QuestionData("What is the SI unit of temperature?", "Kelvin", "Celsius", "Fahrenheit", "Rankine", "Kelvin"));
        physicsTotal.add(new QuestionData("What is the phenomenon where a wave changes direction as it passes from one medium to another?", "Refraction", "Reflection", "Diffraction", "Interference", "Refraction"));
        physicsTotal.add(new QuestionData("What is the force that acts on an object due to gravity?", "Weight", "Mass", "Inertia", "Friction", "Weight"));
        physicsTotal.add(new QuestionData("What is the SI unit of frequency?", "Hertz", "Watt", "Joule", "Ampere", "Hertz"));
        physicsTotal.add(new QuestionData("What is the SI unit of wavelength?", "Meter", "Kilogram", "Second", "Coulomb", "Meter"));
        physicsTotal.add(new QuestionData("What is the change in an object's position with respect to time?", "Velocity", "Acceleration", "Speed", "Distance", "Velocity"));
        physicsTotal.add(new QuestionData("What is the process by which energy is transferred through a medium by vibrations of particles?", "Mechanical Wave", "Electromagnetic Wave", "Sound Wave", "Light Wave", "Mechanical Wave"));
        physicsTotal.add(new QuestionData("What is the law that states that the volume of a given mass of gas is directly proportional to its Kelvin temperature if the pressure is kept constant?", "Charles's Law", "Boyle's Law", "Gay-Lussac's Law", "Avogadro's Law", "Charles's Law"));
        physicsTotal.add(new QuestionData("What is the phenomenon where a wave bounces off a surface?", "Reflection", "Refraction", "Diffraction", "Interference", "Reflection"));
        physicsTotal.add(new QuestionData("What is the SI unit of momentum?", "Kilogram meter per second", "Newton", "Joule", "Ampere", "Kilogram meter per second"));
        physicsTotal.add(new QuestionData("What is the law that states that every particle attracts every other particle with a force that is directly proportional to the product of their masses and inversely proportional to the square of the distance between their centers?", "Law of Universal Gravitation", "Newton's First Law", "Newton's Second Law", "Newton's Third Law", "Law of Universal Gravitation"));
        physicsTotal.add(new QuestionData("What is the process of a gas changing directly into a solid?", "Deposition", "Sublimation", "Evaporation", "Condensation", "Deposition"));
        physicsTotal.add(new QuestionData("What is the rate of change of displacement?", "Velocity", "Acceleration", "Speed", "Distance", "Velocity"));
        physicsTotal.add(new QuestionData("What is the law that states that the volume of a gas is inversely proportional to the pressure if the temperature and the quantity of gas are held constant?", "Boyle's Law", "Charles's Law", "Gay-Lussac's Law", "Avogadro's Law", "Boyle's Law"));
        physicsTotal.add(new QuestionData("What is the SI unit of electric potential difference?", "Volt", "Ohm", "Ampere", "Watt", "Volt"));
        physicsTotal.add(new QuestionData("What is the process of a liquid changing into a solid?", "Freezing", "Melting", "Evaporation", "Condensation", "Freezing"));
        physicsTotal.add(new QuestionData("What is the SI unit of gravitational constant?", "N m^2/kg^2", "m/s^2", "Joule", "Kilogram", "N m^2/kg^2"));
        physicsTotal.add(new QuestionData("What is the energy stored in an object due to its position?", "Potential Energy", "Kinetic Energy", "Mechanical Energy", "Thermal Energy", "Potential Energy"));
        physicsTotal.add(new QuestionData("What is the phenomenon where a wave bends as it passes around a barrier or through an opening?", "Diffraction", "Reflection", "Refraction", "Interference", "Diffraction"));
        physicsTotal.add(new QuestionData("What is the SI unit of work?", "Joule", "Watt", "Newton", "Ampere", "Joule"));
        physicsTotal.add(new QuestionData("What is the property of a wave that determines its brightness?", "Intensity", "Frequency", "Amplitude", "Wavelength", "Intensity"));
        physicsTotal.add(new QuestionData("What is the law that states that the total entropy of an isolated system can never decrease over time?", "Second Law of Thermodynamics", "First Law of Thermodynamics", "Third Law of Thermodynamics", "Zeroth Law of Thermodynamics", "Second Law of Thermodynamics"));
        Collections.shuffle(physicsTotal);
        physicsQuestiondata = physicsTotal.subList(0, 20);
    }

    private void englishQuestions() {
        englishQuestionData = new ArrayList<>();

        ArrayList<QuestionData> englishTotal = new ArrayList<>();
        englishTotal.add(new QuestionData("Choose the correct form of the verb: She _______ to the store yesterday.", "went", "go", "gone", "going", "went"));
        englishTotal.add(new QuestionData("What is the plural form of 'child'?", "children", "childs", "childen", "child's", "children"));
        englishTotal.add(new QuestionData("Which sentence is in the present perfect tense?", "I have finished my homework.", "I finished my homework.", "I will finish my homework.", "I finish my homework.", "I have finished my homework."));
        englishTotal.add(new QuestionData("Choose the correct pronoun: My sister and _______ are going to the park.", "I", "me", "myself", "mine", "I"));
        englishTotal.add(new QuestionData("What is the comparative form of 'good'?", "better", "gooder", "more good", "well", "better"));
        englishTotal.add(new QuestionData("Which word is a preposition: The cat is hiding _______ the table.", "under", "run", "quickly", "and", "under"));
        englishTotal.add(new QuestionData("What is the superlative form of 'big'?", "biggest", "bigly", "bigger", "most big", "biggest"));
        englishTotal.add(new QuestionData("Identify the correct sentence: a) She are a teacher. b) She is a teacher.", "b) She is a teacher.", "a) She are a teacher.", "Both are correct.", "None is correct.", "b) She is a teacher."));
        englishTotal.add(new QuestionData("Which sentence uses correct punctuation?", "I went to the store, and bought some apples.", "I went to the store and bought some apples.", "I went to the store and, bought some apples.", "I went, to the store and bought some apples.", "I went to the store and bought some apples."));
        englishTotal.add(new QuestionData("What is the past participle of the verb 'eat'?", "eaten", "ate", "eat", "eated", "eaten"));
        englishTotal.add(new QuestionData("Choose the correct form of 'to be': She _______ tired.", "is", "am", "are", "be", "is"));
        englishTotal.add(new QuestionData("What type of sentence is this: Have you seen my keys?", "Interrogative", "Imperative", "Declarative", "Exclamatory", "Interrogative"));
        englishTotal.add(new QuestionData("Choose the correct form of the adjective: This is the _______ book I've ever read.", "best", "goodest", "better", "most best", "best"));
        englishTotal.add(new QuestionData("Identify the adverb: She sings very beautifully.", "very", "sings", "beautifully", "she", "very"));
        englishTotal.add(new QuestionData("What is the past tense of the verb 'run'?", "ran", "run", "running", "runs", "ran"));
        englishTotal.add(new QuestionData("Which sentence uses the correct verb tense: a) They will went to the party. b) They will go to the party.", "b) They will go to the party.", "a) They will went to the party.", "Both are correct.", "None is correct.", "b) They will go to the party."));
        englishTotal.add(new QuestionData("What is the indefinite article?", "a", "an", "the", "none", "a"));
        englishTotal.add(new QuestionData("What is the plural form of 'man'?", "men", "manes", "mans", "man's", "men"));
        englishTotal.add(new QuestionData("Which word is an adverb: She speaks loudly.", "loudly", "speak", "she", "speaks", "loudly"));
        englishTotal.add(new QuestionData("Choose the correct form of 'to be': They _______ at home.", "are", "am", "is", "be", "are"));
        englishTotal.add(new QuestionData("What is the comparative form of 'beautiful'?", "more beautiful", "beautifuler", "most beautiful", "beautifully", "more beautiful"));
        englishTotal.add(new QuestionData("Identify the conjunction: I like both apples _______ oranges.", "and", "both", "like", "apples", "and"));
        englishTotal.add(new QuestionData("What is the past participle of the verb 'write'?", "written", "writed", "wrote", "writing", "written"));
        englishTotal.add(new QuestionData("Choose the correct pronoun: _______ is a doctor.", "She", "Her", "Hers", "She's", "She"));
        englishTotal.add(new QuestionData("What type of sentence is this: Please pass me the salt.", "Imperative", "Interrogative", "Declarative", "Exclamatory", "Imperative"));
        englishTotal.add(new QuestionData("Which sentence uses correct punctuation?", "Can I go with you?", "Can, I go with you.", "Can I go, with you.", "Can I, go with you?", "Can I go with you?"));
        englishTotal.add(new QuestionData("What is the superlative form of 'bad'?", "worst", "bader", "more bad", "baddest", "worst"));
        englishTotal.add(new QuestionData("Choose the correct form of the verb: She _______ a good student.", "is", "am", "are", "be", "is"));
        englishTotal.add(new QuestionData("What is the adverb form of the adjective 'quick'?", "quickly", "quickness", "quicker", "quicknessly", "quickly"));
        englishTotal.add(new QuestionData("Identify the interjection: Wow, that's amazing!", "Wow", "That's", "Amazing", "that", "Wow"));
        englishTotal.add(new QuestionData("What is the plural form of 'person'?", "people", "persons", "peoples", "person's", "people"));
        englishTotal.add(new QuestionData("Which word is a conjunction: She likes both ice cream _______ cake.", "and", "likes", "both", "ice cream", "and"));
        englishTotal.add(new QuestionData("Choose the correct form of 'to be': He _______ my brother.", "is", "am", "are", "be", "is"));
        englishTotal.add(new QuestionData("What is the comparative form of 'bad'?", "worse", "badly", "more bad", "baddest", "worse"));
        englishTotal.add(new QuestionData("Identify the article: _______ apple fell from the tree.", "An", "The", "A", "None", "An"));
        englishTotal.add(new QuestionData("What is the past tense of the verb 'read'?", "read", "reading", "reads", "red", "read"));
        englishTotal.add(new QuestionData("Which sentence uses the correct verb tense: a) They have went to the party. b) They have gone to the party.", "b) They have gone to the party.", "a) They have went to the party.", "Both are correct.", "None is correct.", "b) They have gone to the party."));
        englishTotal.add(new QuestionData("What is the comparative form of 'easy'?", "easier", "easyer", "more easy", "most easy", "easier"));

        Collections.shuffle(englishTotal);
        englishQuestionData = englishTotal.subList(0, 20);

    }

    private void loadMathViews() {
        variants = new ArrayList<>();
        questionTextView = findViewById(R.id.question_tv);

        findViewById(R.id.btn_next).setOnClickListener(this::clickNextMath);

        variants.add(findViewById(R.id.answer1_layout));
        variants.add(findViewById(R.id.answer2_layout));
        variants.add(findViewById(R.id.answer3_layout));
        variants.add(findViewById(R.id.answer4_layout));

        variants.forEach(v -> v.setOnClickListener(this::itemClick));
    }

    private void loadPhysicsViews() {
        variants = new ArrayList<>();
        questionTextView = findViewById(R.id.question_tv);

        findViewById(R.id.btn_next).setOnClickListener(this::clickNextPhysics);

        variants.add(findViewById(R.id.answer1_layout));
        variants.add(findViewById(R.id.answer2_layout));
        variants.add(findViewById(R.id.answer3_layout));
        variants.add(findViewById(R.id.answer4_layout));

        variants.forEach(v -> v.setOnClickListener(this::itemClick));
    }

    private void loadEnglishViews() {
        variants = new ArrayList<>();
        questionTextView = findViewById(R.id.question_tv);

        findViewById(R.id.btn_next).setOnClickListener(this::clickNextEnglish);
        variants.add(findViewById(R.id.answer1_layout));
        variants.add(findViewById(R.id.answer2_layout));
        variants.add(findViewById(R.id.answer3_layout));
        variants.add(findViewById(R.id.answer4_layout));

        variants.forEach(v -> v.setOnClickListener(this::itemClick));
    }

    private void loadDataToMathView() {
        QuestionData data = mathQuestionData.get(currentQuestion);
        questionTextView.setText(data.getQuestion());
        setVariantText(variants.get(0), data.getOption1());
        setVariantText(variants.get(1), data.getOption2());
        setVariantText(variants.get(2), data.getOption3());
        setVariantText(variants.get(3), data.getOption4());
        if (selectedItem != null) {
            setIconVisibility(selectedItem, View.INVISIBLE);
            selectedItem.setBackgroundResource(R.drawable.back_linear);
            selectedItem = null;
        }
    }

    private void loadDataToEnglishView() {
        QuestionData data = englishQuestionData.get(currentQuestion);
        questionTextView.setText(data.getQuestion());
        setVariantText(variants.get(0), data.getOption1());
        setVariantText(variants.get(1), data.getOption2());
        setVariantText(variants.get(2), data.getOption3());
        setVariantText(variants.get(3), data.getOption4());
        if (selectedItem != null) {
            setIconVisibility(selectedItem, View.INVISIBLE);
            selectedItem.setBackgroundResource(R.drawable.back_linear);
            selectedItem = null;
        }
    }

    private void loadDataToPhysicsView() {
        QuestionData data = physicsQuestiondata.get(currentQuestion);
        questionTextView.setText(data.getQuestion());
        setVariantText(variants.get(0), data.getOption1());
        setVariantText(variants.get(1), data.getOption2());
        setVariantText(variants.get(2), data.getOption3());
        setVariantText(variants.get(3), data.getOption4());
        if (selectedItem != null) {
            setIconVisibility(selectedItem, View.INVISIBLE);
            selectedItem.setBackgroundResource(R.drawable.back_linear);
            selectedItem = null;
        }
    }

    private void itemClick(View view) {
        if (selectedItem == null) {
            setIconVisibility(view, View.VISIBLE);
            view.setBackgroundResource(R.drawable.back_done_linear);
            selectedItem = view;
        } else {
            selectedItem.setBackgroundResource(R.drawable.back_linear);
            setIconVisibility(selectedItem, View.INVISIBLE);
            view.setBackgroundResource(R.drawable.back_done_linear);
            setIconVisibility(view, View.VISIBLE);
            selectedItem = view;
        }


    }

    private void clickNextMath(View view) {
        if (selectedItem == null) {
            Toast.makeText(this, "Please, select one!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (currentQuestion == mathQuestionData.size() - 1) {
            findViewById(R.id.btn_next).setBackgroundResource(R.drawable.back_btn2);
            Intent intent = new Intent(this, ScoreActivity.class);
            intent.putExtra("score", correctCount);
            startActivity(intent);
            finish();
            return;
        }
        String selectedVariant = getVariantText(selectedItem);
        QuestionData item = mathQuestionData.get(currentQuestion);
        String answer = item.getAnswer();
        if (selectedVariant.equals(answer)) {
            correctCount++;
        } else {
            wrongCount++;
        }
        currentQuestion++;
        CurrentQuestionText = findViewById(R.id.count_text);
        CurrentQuestionText.setText(String.valueOf(currentQuestion + 1));
        loadDataToMathView();
    }

    private void clickNextEnglish(View view) {
        if (selectedItem == null) {
            Toast.makeText(this, "Please, select one!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (currentQuestion == englishQuestionData.size() - 1) {
            Intent intent = new Intent(this, ScoreActivity.class);
            intent.putExtra("score", correctCount);
            startActivity(intent);
            finish();
            return;
        }
        String selectedVariant = getVariantText(selectedItem);
        QuestionData item = englishQuestionData.get(currentQuestion);
        String answer = item.getAnswer();
        if (selectedVariant.equals(answer)) {
            correctCount++;
        } else {
            wrongCount++;
        }
        currentQuestion++;
        CurrentQuestionText = findViewById(R.id.count_text);
        CurrentQuestionText.setText(String.valueOf(currentQuestion + 1));
        loadDataToEnglishView();
    }

    private void clickNextPhysics(View view) {
        if (selectedItem == null) {
            Toast.makeText(this, "Please, select one!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (currentQuestion == physicsQuestiondata.size() - 1) {
            Intent intent = new Intent(this, ScoreActivity.class);
            intent.putExtra("score", correctCount);
            startActivity(intent);
            finish();
            return;
        }
        String selectedVariant = getVariantText(selectedItem);
        QuestionData item = physicsQuestiondata.get(currentQuestion);
        String answer = item.getAnswer();
        if (selectedVariant.equals(answer)) {
            correctCount++;
        } else {
            wrongCount++;
        }
        currentQuestion++;
        CurrentQuestionText = findViewById(R.id.count_text);
        CurrentQuestionText.setText(String.valueOf(currentQuestion + 1));
        loadDataToPhysicsView();
    }

    private void setIconVisibility(View item, int visibility) {
        ImageView iconView = item.findViewById(R.id.selected_btn);
        iconView.setVisibility(visibility);
    }

    private void setVariantText(View item, String text) {
        TextView textVariant = item.findViewById(R.id.answer_text);
        textVariant.setText(text);
    }

    private String getVariantText(View item) {
        TextView textVariant = item.findViewById(R.id.answer_text);
        return textVariant.getText().toString();
    }

    @Override
    public void onBackPressed() {
        FinishDialog dialog = new FinishDialog();
        dialog.setFinishListener(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            dialog.dismiss();
        });
        dialog.show(getSupportFragmentManager(), null);
    }
}