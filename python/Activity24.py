import pytest

@pytest.fixture
def wallet():
    return 0

@pytest.mark.parametrize("earned,spent,expected",[(30,10,20),(20,2,18)])
def test_purse(wallet,earned,spent,expected):
    wallet+=earned
    wallet-=spent
    assert wallet==expected