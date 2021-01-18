const{browser}=require("protractor");
const { Driver } = require("selenium-webdriver/chrome");

//Asynchronous Sample in Protractor
//Srcipts running in sequence
describe('Protractor baby steps', function() {
    browser.driver.manage().window().maximize();
    browser.waitForAngularEnabled(false);

    it('Open Website', function() {
        //Write real protractor code
        browser.get('https://angularjs.org');
       
        //Promise execution
        browser.get('https://github.com/juliemr/protractor-demo').then(function() {
            
        console.log("I am the last step");
        });

        
                 
    })
    
    it('Close Website', function() {
        //Write real protractor code
        
        
    })


});