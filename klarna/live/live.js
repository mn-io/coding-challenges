const solver = function () {
    const diffCoordinate = (a,b) => {
        return {
            x: b.x - a.x,
            y: b.y - a.y
        }
    }

    const recursion = (delta) => {
        if (delta.x === 0 || delta.y === 0) {
            return 1
        }

        const pathNrsX = recursion({ x: delta.x - 1,y: delta.y })
        const pathNrsY = recursion({ x: delta.x,y: delta.y - 1 })

        return pathNrsX + pathNrsY
    }


    const pathNr = (a,b) => {
        const delta = diffCoordinate(a,b)
        return recursion(delta)
    }

    return {
        pathNr
    }
}

const s = solver()
console.log(s.pathNr({ x: 0,y: 0 },{ x: 2,y: 2 }),6)
console.log(s.pathNr({ x: 0,y: 0 },{ x: 2,y: 5 }),21)
console.log(s.pathNr({ x: 0,y: 0 },{ x: 3,y: 7 }),120)
