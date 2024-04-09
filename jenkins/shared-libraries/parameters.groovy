import hudson.model.*

def parametersForProvisioningInstallAppium(utilsModule) {
  properties(
    [
      parameters(
        [
          string(
            name: 'AGENT_LABEL',
            defaultValue: utilsModule.createStringWithPreviousValue('master', "${params.AGENT_LABEL}"),
            description: 'The label of Jenkins agent where the script will be executed on it'
          ),
          booleanParam(
            name: 'MOBILE_INSTALL_APPIUM',
            defaultValue: utilsModule.createBooleanWithPreviousValue(true, "${params.MOBILE_INSTALL_APPIUM}"),
            description: 'Install Appium in the node machine',
          ),
          booleanParam(
            name: 'MOBILE_INSTALL_APPIUM_DRIVERS',
            defaultValue: utilsModule.createBooleanWithPreviousValue(true, "${params.MOBILE_INSTALL_APPIUM_DRIVERS}"),
            description: 'Install Appium drivers: uiautomator2 (for Android)',
          ),
          booleanParam(
            name: 'MOBILE_INSTALL_APPIUM_CHROMEDRIVER',
            defaultValue: utilsModule.createBooleanWithPreviousValue(true, "${params.MOBILE_INSTALL_APPIUM_CHROMEDRIVER}"),
            description: 'Install ChromeDriver inside Appium drivers',
          ),
          string(
            name: 'MOBILE_CHROME_DRIVER_DOWNLOAD',
            defaultValue: 'https://chromedriver.storage.googleapis.com/113.0.5672.63/chromedriver_win32.zip',
            description: 'Link to download specific ChromeDriver version',
          ),
        ]
      )
    ]
  )
}

def parametersForProvisioningStartEmulator(utilsModule) {
  properties(
    [
      parameters(
        [
          string(
            name: 'AGENT_LABEL',
            defaultValue: utilsModule.createStringWithPreviousValue('master', "${params.AGENT_LABEL}"),
            description: 'The label of Jenkins agent where the script will be executed on it'
          ),
          booleanParam(
            name: 'MOBILE_INSTALL_ANDROID_CMD_TOOL',
            defaultValue: utilsModule.createBooleanWithPreviousValue(true, "${params.MOBILE_INSTALL_ANDROID_CMD_TOOL}"),
            description: 'Install Android Commandline Tools',
          ),
          string(
            name: 'ANDROID_SDK_MANAGER_NO_HTTPS',
            defaultValue: utilsModule.createStringWithPreviousValue('--no_https', "${params.ANDROID_SDK_MANAGER_NO_HTTPS}"),
            description: 'Android SDK Manager use HTTP only for download packages',
          ),
          string(
            name: 'ANDROID_CMD_TOOL_DOWNLOAD',
            defaultValue: utilsModule.createStringWithPreviousValue('https://dl.google.com/android/repository/commandlinetools-win-11076708_latest.zip', "${params.ANDROID_CMD_TOOL_DOWNLOAD}"),
            description: 'URL to download the package for Android Commandline Tools'
          ),
          booleanParam(
            name: 'MOBILE_INSTALL_ANDROID_IMAGE',
            defaultValue: utilsModule.createBooleanWithPreviousValue(true, "${params.MOBILE_INSTALL_ANDROID_IMAGE}"),
            description: 'Install Android system image',
          ),
          string(
            name: 'ANDROID_SYSTEM_ABI',
            defaultValue: utilsModule.createStringWithPreviousValue('x86_64', "${params.ANDROID_SYSTEM_ABI}"),
            description: 'Application Binary Interface (ABI)'
          ),
          string(
            name: 'ANDROID_PLATFORM_API',
            defaultValue: utilsModule.createStringWithPreviousValue('android-34', "${params.ANDROID_PLATFORM_API}"),
            description: 'Android platform API'
          ),
          string(
            name: 'ANDROID_EMULATOR_DEVICE_ID',
            defaultValue: utilsModule.createStringWithPreviousValue('pixel_8', "${params.ANDROID_EMULATOR_DEVICE_ID}"),
            description: 'Device ID is used to create emulator (should select from supports list)'
          ),
          string(
            name: 'ANDROID_EMULATOR_NAME',
            defaultValue: utilsModule.createStringWithPreviousValue('test-emulator-1', "${params.ANDROID_EMULATOR_NAME}"),
            description: 'Emulator name for creation'
          ),
          booleanParam(
            name: 'MOBILE_INSTALL_ANDROID_EMULATOR_CREATE',
            defaultValue: utilsModule.createBooleanWithPreviousValue(true, "${params.MOBILE_INSTALL_ANDROID_EMULATOR_CREATE}"),
            description: 'Install create the default emulator',
          ),
          booleanParam(
            name: 'MOBILE_INSTALL_ANDROID_EMULATOR_FORCE_STOP',
            defaultValue: utilsModule.createBooleanWithPreviousValue(true, "${params.MOBILE_INSTALL_ANDROID_EMULATOR_FORCE_STOP}"),
            description: 'Force stop previous emulator session before starting new one',
          ),
          booleanParam(
            name: 'MOBILE_INSTALL_ANDROID_EMULATOR_START',
            defaultValue: utilsModule.createBooleanWithPreviousValue(true, "${params.MOBILE_INSTALL_ANDROID_EMULATOR_START}"),
            description: 'Start the default emulator',
          ),
        ]
      )
    ]
  )
}

def parametersForRunTestKatalon(utilsModule) {
  properties(
    [
      parameters(
        [
          string(
            name: 'AGENT_LABEL',
            defaultValue: utilsModule.createStringWithPreviousValue('master', "${params.AGENT_LABEL}"),
            description: 'The label of Jenkins agent where the script will be executed on it'
          ),
          credentials(
            name: 'GIT_CREDENTIAL',
            defaultValue: utilsModule.createStringWithPreviousValue('', "${params.GIT_CREDENTIAL}"),
            description: 'The credential to access the Git repository',
            credentialType: 'Username with password',
            required: false
          ),
          string(
            name: 'REPO_URL',
            defaultValue: utilsModule.createStringWithPreviousValue('', "${params.REPO_URL}"),
            description: 'The URL of the Git repository'
          ),
          string(
            name: 'BRANCH',
            defaultValue: utilsModule.createStringWithPreviousValue('', "${params.BRANCH}"),
            description: 'The branch of the Git repository'
          ),
          string(
            name: 'KATALON_ENGINE_DIR',
            defaultValue: utilsModule.createStringWithPreviousValue('', "${params.KATALON_ENGINE_DIR}"),
            description: 'The directory to access Katalon Engine binary'
          ),
          string(
            name: 'PROJECT_PATH',
            defaultValue: utilsModule.createStringWithPreviousValue('/', "${params.PROJECT_PATH}"),
            description: 'The path to the project'
          ),
          string(
            name: 'TEST_SUITE_PATH',
            defaultValue: utilsModule.createStringWithPreviousValue('', "${params.TEST_SUITE_PATH}"),
            description: 'The path to the test suite'
          ),
          string(
            name: 'PROFILE',
            defaultValue: utilsModule.createStringWithPreviousValue('default', "${params.PROFILE}"),
            description: 'The profile to run the test suite'
          ),
          choice(
            name: 'BROWSER',
            choices: utilsModule.createChoicesWithPreviousChoice(['Android', 'Chrome', 'Firefox', 'MicrosoftEdge'], "${params.BROWSER}"),
            description: 'The browser to run the test suite'
          ),
          string(
            name: 'EMULATOR_NAME',
            defaultValue: utilsModule.createStringWithPreviousValue('', "${params.EMULATOR_NAME}"),
            description: 'Emulator name for mobile browser selected'
          ),
          string(
            name: 'RETRY',
            defaultValue: utilsModule.createStringWithPreviousValue('0', "${params.RETRY}"),
            description: 'The number of retries if the test suite fails'
          ),
          credentials(
            name: 'TEST_OPS_API',
            defaultValue: utilsModule.createStringWithPreviousValue('', "${params.TEST_OPS_API}"),
            description: 'The API key to access Katalon TestOps',
            credentialType: 'Username with password',
            required: false
          ),
          booleanParam(
            name: 'CONFIG_WEBUI_AUTO_UPDATE_DRIVERS',
            defaultValue: utilsModule.createBooleanWithPreviousValue(false, "${params.CONFIG_WEBUI_AUTO_UPDATE_DRIVERS}"),
            description: 'Set configuration to auto update WebUI drivers',
          ),
        ]
      )
    ]
  )
}

return this