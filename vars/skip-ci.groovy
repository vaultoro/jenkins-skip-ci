def get_skip_ci_options() {
  def skipCi = false
  def skipTest = false
  echo "getting latest commit message"

  def latestCommitMessage = sh (
  script: 'git log -1 --pretty=%B ${GIT_COMMIT}', returnStdout: true
  ).trim()

  echo "Latest commit message is: ${latestCommitMessage}"

  if (latestCommitMessage.contains('skip ci') || latestCommitMessage.contains('ci skip')) {
	skipCi = true
  }
  echo "Skip ci variable is ${skipCi}"

  if (latestCommitMessage.contains('skip test') || latestCommitMessage.contains('test skip')) {
	skipTest = true
  }
  echo "Skip test variable is ${skipTest}"
  return [skipCi, skipTest]
}

def say_hello() {
    def name = "BERATBERATBERAT"
    echo "${skipCi}"
}
