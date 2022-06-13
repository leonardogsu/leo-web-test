Feature: Feature_A
	As client I would like to verify calatolg endpoint

Scenario: Scenario_A
	Given an authorized client
	When an authorized client goes to catalog endpoit
	Then catalog status is "true"
	Then calalog number of items are: 10

Scenario: Scenario_B
	When client uses invalid client id to get access_token
	Then error description with text "Invalid client authentication" is sent
	Then error type is "invalid_client"