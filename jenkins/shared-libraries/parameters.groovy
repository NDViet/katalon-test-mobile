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
                                          defaultValue: true,
                                          description: 'Install Appium in the node machine',
                                  ),
                                  booleanParam(
                                          name: 'MOBILE_INSTALL_APPIUM_DRIVERS',
                                          defaultValue: true,
                                          description: 'Install Appium drivers: uiautomator2 (for Android)',
                                  ),
                                  booleanParam(
                                          name: 'MOBILE_INSTALL_APPIUM_CHROMEDRIVER',
                                          defaultValue: true,
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
                                          defaultValue: true,
                                          description: 'Install Android Commandline Tools',
                                  ),
                                  string(
                                          name: 'ANDROID_SDK_MANAGER_NO_HTTPS',
                                          defaultValue: utilsModule.createStringWithPreviousValue('--no-https', "${params.ANDROID_SDK_MANAGER_NO_HTTPS}"),
                                          description: 'Android SDK Manager use HTTP only for download packages',
                                  ),
                                  string(
                                          name: 'ANDROID_CMD_TOOL_DOWNLOAD',
                                          defaultValue: utilsModule.createStringWithPreviousValue('https://dl.google.com/android/repository/commandlinetools-win-11076708_latest.zip', "${params.ANDROID_CMD_TOOL_DOWNLOAD}"),
                                          description: 'URL to download the package for Android Commandline Tools'
                                  ),
                                  booleanParam(
                                          name: 'MOBILE_INSTALL_ANDROID_IMAGE',
                                          defaultValue: true,
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
                                          defaultValue: true,
                                          description: 'Install create the default emulator',
                                  ),
                                  booleanParam(
                                          name: 'MOBILE_INSTALL_ANDROID_EMULATOR_FORCE_STOP',
                                          defaultValue: true,
                                          description: 'Force stop previous emulator session before starting new one',
                                  ),
                                  booleanParam(
                                          name: 'MOBILE_INSTALL_ANDROID_EMULATOR_START',
                                          defaultValue: true,
                                          description: 'Start the default emulator',
                                  ),
                          ]
                  )
          ]
  )
}

return this