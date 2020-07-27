const Utils = () => {
    const addNodeIfMissing = (nodes,node) => {
        if (!nodes[node]) {
            nodes[node] = {
                name: node,
                visited: false,
                incomingEdges: 0,
                outgoingEdges: []
            }
        }

        return nodes[node]
    }

    const traverse = (currentNode,visitedNodes) => {
        currentNode.visited = true
        visitedNodes.push(currentNode)

        for (let i = 0; i < currentNode.outgoingEdges.length; i++) {
            const successorNode = currentNode.outgoingEdges[i]
            if (!successorNode.visited) {
                traverse(successorNode,visitedNodes)
                return
            }
            visitedNodes.push(currentNode)
        }
    }

    const findRoutes = (routes) => {
        if (!Array.isArray(routes)) {
            throw Error('parameter is not an array')
        }

        const nodes = {}
        routes.forEach(route => {
            const startNodeName = route[0]
            addNodeIfMissing(nodes,startNodeName)

            const endNodeName = route[1]
            const endNode = addNodeIfMissing(nodes,endNodeName)

            nodes[startNodeName].outgoingEdges.push(endNode)
            nodes[endNodeName].incomingEdges += 1
        })

        const startNodeKeys = Object.keys(nodes).filter(key => nodes[key].incomingEdges === 0)
        if (Object.keys(startNodeKeys).length !== 1) {
            throw Error('exactly one start node has to be found, without any incoming edges')
        }
        const startNode = nodes[startNodeKeys[0]]
        const resultGraph = []

        traverse(startNode,resultGraph)

        return resultGraph.map(r => r.name).join(', ')
    }

    return {
        findRoutes
    }
}

const utils = Utils()
const findRoutes = utils.findRoutes

console.log(findRoutes([
    ['M','T'],
    ['C','X'],
    ['X','T'],
    ['T','C'],
    ['T','B']
]))
