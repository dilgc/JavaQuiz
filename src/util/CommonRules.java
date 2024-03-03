package util;

/**
 * Sets the rules for what symbols and character limits are allowed for
 * titles, questions, answers, and result names, as well as additional rules
 * such as the maximum number of questions a quiz can have.
 *
 * Sets a higher size limiter for descriptions which may be lengthier.
 */
public interface CommonRules {
    String COMMON_REGEX = "[a-zA-Z0-9\\-,.?!_*:=()\\[\\]\\s]+";
    int COMMON_SIZE = 100;
    int DESCRIPTION_SIZE = 500;
    int MAXIMUM_QUESTIONS = 50;
}
