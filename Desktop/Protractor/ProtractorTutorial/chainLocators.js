const{browser, element}=require("protractor");
const { protractor } = require("protractor/built/ptor");
const { Driver } = require("selenium-webdriver/chrome");

describe('Chain Locators demo', function() {
    browser.driver.manage().window().maximize();
    browser.waitForAngularEnabled(false);

    it('Chain Locators sample', function() {
        //repeater, chain locators, css for identical tags
        browser.get("http://juliemr.github.io/protractor-demo/");
        element(by.model("first")).sendKeys("12");
        element(by.model("second")).sendKeys("13");
        element(by.css("button[ng-click='doAddition()']")).click();
        //chain locator meaning parent is repeater
        browser.sleep(8000);
        element.all(by.repeater("result in memory")).each(function(item) {
            item.element(by.css("td:nth-child(3)")).getText().then(function(text) {

                console.log(text);
            })
        })

    })

});