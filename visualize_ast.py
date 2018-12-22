import ast
import sys
from astmonkey import visitors, transformers

def main():
    code = ''
    for line in sys.stdin:
        code += line
        print(line)
    node = ast.parse(code)
    node = transformers.ParentChildNodeTransformer().visit(node)
    visitor = visitors.GraphNodeVisitor()
    visitor.visit(node)

    visitor.graph.write_png('src/main/resources/graph.png')

if __name__ == "__main__":
    main()
