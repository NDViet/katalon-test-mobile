import hudson.model.*

def executeCommand(def command) {
  println "${command}"
  def response
  try {
    if (isUnix()) {
      response = sh(returnStdout: true, script: "${command}").trim()
    } else {
      response = bat(returnStdout: true, script: "${command}").trim().readLines().drop(1).join("\\n")
    }
  } catch (Exception err) {
    println "${response}"
    throw err
  }
  return response
}

def maskingSecret(def variable) {
  if (isUnix()) {
    return '${' + variable + '}'
  } else {
    return '%' + variable + '%'
  }
}

def cleanUpDirectory(def target) {
  if (isUnix()) {
    executeCommand('rm -rf "' + target + '"')
  } else {
    target = replaceFileSeparator(target)
    executeCommand('if exist "' + target + '" rmdir /S /Q "' + target + '"')
  }
}

def replaceFileSeparator(def command) {
  if (isUnix()) {
    return command
  } else {
    return command.replaceAll("/", "\\\\")
  }
}

def getKatalonExecutionFile() {
  if (isUnix()) {
    return 'katalonc'
  } else {
    return 'katalonc.exe'
  }
}

def getEmulatorName(def browser) {
  if (browser == 'Android') {
    return 'emulator-5554'
  }
  return ''
}

static boolean isNull(def listParams) {
  for (def value : listParams) {
    if (value == null) {
      return true
    } else if (value == "null") {
      return true
    }
  }
  return false
}

List createChoicesWithPreviousChoice(List defaultChoices, def previousChoice) {
  if (isNull([previousChoice])) {
    return defaultChoices
  }
  choices = defaultChoices.minus(previousChoice)
  choices.add(0, previousChoice)
  return choices
}

String createStringWithPreviousValue(String defaultValue, def previousValue) {
  if (isNull([previousValue])) {
    return defaultValue
  }
  return previousValue
}

boolean createBooleanWithPreviousValue(boolean defaultValue, def previousValue) {
  if (isNull([previousValue])) {
    return defaultValue
  }
  return previousValue
}

return this