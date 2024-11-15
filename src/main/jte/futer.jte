@import gg.jte.Content
@param Content content

@template.layout.content(
    content = @`
        <footer>
            <p>Контакты: <a href="mailto:example@example.com">example@example.com</a></p>
            <p><a href="https://github.com/drinkingsweets" target="_blank">GitHub</a></p>
        </footer>
    `
)