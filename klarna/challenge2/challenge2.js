const Utils = () => {
    const calculateWeight = numberAsString => {
        if (0 === numberAsString.length) {
            return 0
        }
        // This looks elegant, but it can be discussed with the team whether a simple iteration is easier to understand
        return numberAsString
            .split('')
            .map(digitAsString => parseInt(digitAsString,10))
            .reduce((acc,cur) => acc + cur)
    }

    const filterInvalidNumbers = str => {
        if (0 === str.length) {
            return false
        }

        const asNumber = parseInt(str,10)
        const isValidNumber = asNumber + "" === str
        if (!isValidNumber) {
            return false
        }
        if (asNumber < 0) {
            return false
        }
        return true
    }

    const orderWeight = str => {
        if (typeof str !== 'string') {
            throw Error('parameter is not a string')
        }

        if (0 === str.length) {
            return ''
        }

        return str
            .split(' ')
            .filter(filterInvalidNumbers)
            .map(val => ({ weight: calculateWeight(val),val }))
            .sort((a,b) => {
                if (a.weight === b.weight) {
                    return a.val.localeCompare(b.val)
                }
                return a.weight - b.weight
            }).map(obj => obj.val)
            .join(' ')
    }

    return {
        orderWeight
    }
}

const utils = Utils()
const orderWeight = utils.orderWeight

console.log(orderWeight("103 123 4444 99 2000"))
