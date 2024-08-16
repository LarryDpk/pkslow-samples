// Import necessary modules
const { Builder, By, Key, until } = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');

const proxy = require('selenium-webdriver/proxy');

const { expect } = require('chai');
const mocha = require('mocha');

// Describe the test suite
describe('Google Search UI Test', function() {
    let driver;

    // Define the proxy settings
    const myProxy = proxy.manual({
        http: 'localhost:7890',
        https: 'localhost:7890',
    });
    // Set up Chrome options with the proxy
    const chromeOptions = new chrome.Options().setProxy(myProxy);

    // Set timeout
    this.timeout(30000);

    // Before each test, initialize the WebDriver
    before(async function() {
        driver = await new Builder().forBrowser('chrome').setChromeOptions(chromeOptions).build();
    });

    // After each test, quit the WebDriver
    after(async function() {
        await driver.quit();
    });

    // The actual test
    it('should search for a query and display results', async function() {
        // Navigate to Google
        await driver.get('https://www.google.com');

        // Find the search box using its name attribute and type a query
        const searchBox = await driver.findElement(By.name('q'));
        await searchBox.sendKeys('pkslow larry', Key.RETURN);

        // Wait for the results page to load and display the results
        await driver.wait(until.titleContains('pkslow larry'), 10000);

        // Verify that the title contains the search term
        const title = await driver.getTitle();
        expect(title).to.include('pkslow larry');
    });
});
