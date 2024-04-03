import hudson.model.*

def executeCommand(def command) {
    echo "${command}"
    String response = ''
    try {
        if (isUnix()) {
            response = sh(returnStdout: true, script: "${command}").trim()
        }
        else {
            response = bat(returnStdout: true, script: "${command}").trim().readLines().drop(1).join(" ")
        }
    } catch (Exception err) {
        echo "${response}"
        throw err
    }
    return response
}

static boolean isNull(def listParams) {
    for(def value : listParams) {
        if(value == null) {
            return true
        } else if(value == "null") {
            return true
        }
    }
    return false
}

List createChoicesWithPreviousChoice(List defaultChoices, String previousChoice) {
    if (isNull([previousChoice])) {
        return defaultChoices
    }
    choices = defaultChoices.minus(previousChoice)
    choices.add(0, previousChoice)
    return choices
}

String createStringWithPreviousValue(String defaultValue, String previousValue) {
    if (isNull([previousValue])) {
        return defaultValue
    }
    return previousValue
}

return this