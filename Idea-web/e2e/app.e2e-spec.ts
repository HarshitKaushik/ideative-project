import { IdeaWebPage } from './app.po';

describe('idea-web App', () => {
  let page: IdeaWebPage;

  beforeEach(() => {
    page = new IdeaWebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
