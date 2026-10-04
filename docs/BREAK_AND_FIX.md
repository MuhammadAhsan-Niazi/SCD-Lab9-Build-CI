# Break → Fix (Lab 9 activities 3 and 4)

**Break:** commit `test: deliberately break averageOfValues` changed the expected mean from 2.5 to 3.0.
Running the same test command the CI runs (`mvn -B test`) fails at stage 5 (unit tests). The failing
output is in `reports/ci-failing-run-local.txt`: `expected: <3.0> but was: <2.5>`.
Because the job fails, the required status check blocks the merge into `main`.

**Fix:** commit `fix: restore correct expected mean (2.5)` restored the assertion. `reports/ci-passing-run-local.txt`
shows the suite green again.

**Screenshots:** the GitHub Actions run pages for the failing and passing runs must be captured by
pushing this repo to GitHub, since the sandbox that produced this lab cannot reach GitHub.
