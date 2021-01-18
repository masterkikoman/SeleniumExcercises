const { browser, element } = require("protractor");

describe('Java alerts on website', function() {
    browser.driver.manage().window().maximize();
    browser.waitForAngularEnabled(false);

    it('Open Website', function() {
        
        browser.get('https://rahulshettyacademy.com/AutomationPractice/');

    })

    it('Checking alerts on site', function() {
        
        element(by.id("alertbtn")).click();
        //if you want to click positive scenario
        browser.switchTo().alert().accept().then(function(){
            browser.sleep(5000);
        });

        element(by.id("id")).getText().then(function(text){
               console.log(text); 
        })
        
        

    })
    



});