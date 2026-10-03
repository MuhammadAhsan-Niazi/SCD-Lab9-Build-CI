# Lab 9 – Build & CI Documentation

## Setup
1. Push this repository to GitHub (`git remote add origin <url>` then `git push -u origin main`).
2. In GitHub, go to **Settings → Branches → Add rule** for `main`, tick
   **Require status checks to pass before merging**, and select the `build-and-test` job.
   This is what actually blocks a merge when the pipeline is red.

## Stage order and why (Additional Task 1)
1. Checkout – nothing can build without the source.
2. JDK setup – the build must run on a known Java version; a mismatch fails here.
3. Install dependencies (`dependency:go-offline`) – a broken or missing dependency is caught here,
   before any compile or test time is spent (cheapest failure first).
4. Build / compile – syntax and type errors fail in seconds.
5. Unit tests – the most expensive correctness check, so it runs only after cheaper stages pass.
6. Package – an artifact is produced only from code that compiled and passed tests.
7. Upload artifact – the deployable output is kept for download.

## Proposed additional stage (Additional Task 3)
Add the **static analysis** stage from Lab 5 (e.g. `mvn -B checkstyle:check`) between stage 4 and stage 5.
It is cheaper than running tests and catches style or security issues before a test run is spent on code
that would be rejected anyway.

## Fail → fix demonstration
See `docs/BREAK_AND_FIX.md` and the git history on `ci-break-demo`.
