const chai = require('chai');
const expect = chai.expect;

const { add } = require('../src/index');

describe('Addition', () => {
    it('should return 4 when adding 2 + 2', () => {
        const result = add(2, 2);
        expect(result).to.equal(4);
    });
    it('should return 8 when adding 2 + 6', () => {
        const result = add(2, 6);
        expect(result).to.equal(8);
    });
});
