package ru.lobankov.study;

public class AllFalseGradeRule implements GradeRule{
        public static final AllFalseGradeRule INSTANCE = new AllFalseGradeRule();
        private AllFalseGradeRule(){}
        @Override
        public boolean isValid() {
            return false;
        }
}
