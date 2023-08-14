@download
Feature: User Should be able to download any file from application to our framework

  Scenario:User Should be able to download any file from application to our framework
    Given I am in App main site
    Then  I click the "file_download_link" on the "HomePage"
    Then  I click the "test_file" on the "HomePage"
    Then  I wait "5" seconds to synchronize the things on app

