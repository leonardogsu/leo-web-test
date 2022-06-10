Feature: Basic counting - Open list - Multivote - E2E | TestRail ID: 105918 | Run TestRail ID: 0
	As an admin I would like to complete a Basic counting E2E with multivote

	@StopOnFailure
	Scenario: Voting | TestRail ID: 926845
		When setting voters file as "E2E/credentials/singledistrict/multivote-voter.out"
		And setting target election from "E2E/election.txt"
		When executing voting process
		Then total failed logins is 0
		And total failed votes is 0
