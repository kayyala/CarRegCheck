Feature:Vehicle Identity check

@Sanity
Scenario:Validating car registration details from cartaxcheck site with input file and output file
  Given User reads registration details from input file
  When User retrieves vehicle details from cartaxcheck site and verifies details with outputfile
