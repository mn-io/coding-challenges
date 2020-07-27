const Utils = () => {
    const compareFromStartingPosition = (first,second,startingPosition) => {
        for (let i = 0; i < first.length; i++) {
            const j = (i + startingPosition) % first.length
            const f = first[i]
            const s = second[j]

            if (f !== s) {
                return false
            }
        }
        return true
    }

    const shiftedDiff = (first,second) => {
        if (typeof first !== 'string') {
            throw Error('first parameter is not a string')
        }
        if (typeof second !== 'string') {
            throw Error('second parameter is not a string')
        }

        if (first.length !== second.length) {
            return -1
        }

        for (let i = 0; i < first.length; i++) {
            const isIdentical = compareFromStartingPosition(first,second,i)
            if (isIdentical) {
                return i;
            }
        }
        return -1
    }

    return {
        shiftedDiff
    }
}

const utils = Utils()
const shiftedDiff = utils.shiftedDiff

console.log(shiftedDiff('coffee','coffee'),0)

console.log(shiftedDiff('coffee','ecoffe'),1)
console.log(shiftedDiff('coffee','eecoff'),2)
console.log(shiftedDiff('coffee','feecof'),3)
console.log(shiftedDiff('coffee','ffeeco'),4)
console.log(shiftedDiff('coffee','offeec'),5)

console.log(shiftedDiff('offeec','coffee'),1)
console.log(shiftedDiff('ffeeco','coffee'),2)
console.log(shiftedDiff('feecof','coffee'),3)
console.log(shiftedDiff('eecoff','coffee'),4)
console.log(shiftedDiff('ecoffe','coffee'),5)

console.log(shiftedDiff('coffee','eecoff'),2)
console.log(shiftedDiff('eecoff','coffee'),4)
console.log(shiftedDiff('moose','Moose'),-1)
console.log(shiftedDiff("isn't","'tisn"),2)
console.log(shiftedDiff('Esham','Esham'),0)
console.log(shiftedDiff('dog','god'),-1)
