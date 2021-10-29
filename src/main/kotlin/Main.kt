import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.kickstart.tools.SchemaParser


interface TestInterface {
    val testUnion: TestUnion
}

interface TestUnion

class TestUnion1(val a: String?) : TestUnion
class TestUnion2(val b: String?) : TestUnion
class DummyType(val testUnion: TestUnion)

class TestInterfaceImpl(
    override val testUnion: TestUnion1,
    val c: String,
) : TestInterface

class Schema : GraphQLQueryResolver {
    fun query(): TestInterface = TestInterfaceImpl(TestUnion1("a"), "b")
    fun dummy(): DummyType = DummyType(TestUnion1("a"))
}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        SchemaParser
            .newParser()
            .files("schema.graphql")
            .resolvers(Schema())
            .dictionary(
                TestInterfaceImpl::class.java,
                TestUnion1::class.java,
                TestUnion2::class.java,
                TestUnion::class.java,
                TestInterface::class.java,
                DummyType::class.java
            )
            .build()
            .makeExecutableSchema()
    }
}
